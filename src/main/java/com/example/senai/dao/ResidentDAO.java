package com.example.senai.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.senai.model.transport.ListDTO;
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
