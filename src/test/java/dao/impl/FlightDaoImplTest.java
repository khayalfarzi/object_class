package dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.module.ResolutionException;
import java.sql.ResultSet;
import java.sql.SQLException;


class FlightDaoImplTest {

    @Mock
    private ResultSet resultSet;

    @Test
    void selectAllFlights() throws SQLException {

        resultSet = Mockito.mock(ResultSet.class);

        Mockito.when(resultSet.getInt("id")).thenReturn(1);
        Mockito.when(resultSet.getString("serial_number")).thenReturn("25JK11");
        Mockito.when(resultSet.getString("from")).thenReturn("Kiev");

        FlightDaoImpl flightDao = new FlightDaoImpl();
        ResultSet resultSet1 = flightDao.showAllFlights();

        while (resultSet1.next()){
            Assertions.assertEquals(1, resultSet1.getInt("id"));
            break;
        }


    }
}