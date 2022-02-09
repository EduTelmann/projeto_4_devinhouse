package com.example.senai.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.senai.model.transport.ListDTO;
import com.example.senai.model.transport.ReportDTO;
import com.example.senai.model.transport.ResidentDTO;

@Repository
public class ResidentDAO {
	
	public List<ResidentDTO> getResidents() throws SQLException {
        Connection connection = new ConnectionFactoryJDBC().getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM resident RE LEFT JOIN resident_adm RADM ON RE.resident_adm_id = RADM.id;");
        ResultSet rs = stmt.getResultSet();
        List<ResidentDTO> residents = new ArrayList<>();
        while (rs.next()) {
            ResidentDTO resident = getResidentDTO(rs);
            residents.add(resident);
        }
        stmt.close();
        connection.close();
        return residents;
    }
	
	public List<ListDTO> listResidentNames() throws SQLException {
		try (Connection connection = new ConnectionFactoryJDBC().getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.execute("SELECT * FROM resident");
			ResultSet resultSet = stmt.getResultSet();
			List<ListDTO> names = new ArrayList<>();
			while (resultSet.next()) {
				ListDTO resident = getListDTO(resultSet);
				names.add(resident);
			}
			return names;
		}
	}
	
	public List<ListDTO> listResidentsByName(String name) throws SQLException {
		try (Connection connection = new ConnectionFactoryJDBC().getConnection()) {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM resident WHERE name LIKE ?");
			stmt.setString(1, name + "%");
			stmt.execute();
			ResultSet resultSet = stmt.getResultSet();
			List<ListDTO> names = new ArrayList<>();
			while (resultSet.next()) {
				ListDTO resident = getListDTO(resultSet);
				names.add(resident);
			}
			return names;
		}
	}
	
	public Boolean addResident(ResidentDTO residentDTO) {
        try (Connection connection = new ConnectionFactoryJDBC().getConnection()) {
        	
        	PreparedStatement stmt1 = connection.prepareStatement("INSERT INTO resident_adm (email, password, is_admin) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        	stmt1.setString(1, residentDTO.getEmail());
        	stmt1.setString(2, residentDTO.getPassword());
        	stmt1.setInt(3, residentDTO.getIs_admin());
        	stmt1.execute();
        	ResultSet resultSet = stmt1.getGeneratedKeys();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				residentDTO.setAdm_id(id);
			}
        
        	PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO resident (name, lastname, birthday, income, cpf, resident_adm_id) values (?,?,?,?,?,?)");
        	stmt2.setString(1, residentDTO.getName());
        	stmt2.setString(2, residentDTO.getLastName());
        	stmt2.setString(3, residentDTO.getBirthday());
        	stmt2.setBigDecimal(4, residentDTO.getIncome());
        	stmt2.setString(5, residentDTO.getCpf());
        	stmt2.setInt(6, residentDTO.getAdm_id());
        	stmt2.execute();

            return true;
        }catch (SQLException e){
            return false;
        }
    }
	
	public ReportDTO getReport(BigDecimal orcamentoDaVila) throws SQLException {
		ReportDTO report = new ReportDTO();
		report.setOrcamento(orcamentoDaVila);
		Double custo = 0.0;
		try (Connection connection = new ConnectionFactoryJDBC().getConnection()) {
			Statement stmt = connection.createStatement();
			stmt.execute("SELECT SUM(income) as SOMA FROM resident;");
			ResultSet resultSet = stmt.getResultSet();
			while (resultSet.next()) {
				custo = resultSet.getDouble("SOMA");
			}
		}
		//continuar aqui
		
		return report;
	}
	
	public ResidentDTO getResidentDTO(ResultSet rs) throws SQLException {
        ResidentDTO resident = new ResidentDTO();
        resident.setName(rs.getString("name"));
        resident.setLastName(rs.getString("lastname"));
        resident.setBirthday(rs.getString("birthday"));
        resident.setIncome(rs.getBigDecimal("income"));
        resident.setCpf(rs.getString("cpf"));
        resident.setAdm_id(rs.getInt("resident_adm_id"));
        resident.setEmail(rs.getString("email"));
        resident.setPassword(rs.getString("password"));
        resident.setIs_admin(rs.getInt("is_admin"));     
        return resident;
    }
	
	public ListDTO getListDTO(ResultSet rs) throws SQLException {
        ListDTO resident = new ListDTO();
        resident.setName(rs.getString("name"));
        resident.setLastame(rs.getString("lastname"));
        resident.setId(rs.getInt("id"));
        return resident;
    }
	
	
}
