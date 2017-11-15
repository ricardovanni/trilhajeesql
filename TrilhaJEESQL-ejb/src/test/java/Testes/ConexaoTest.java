/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ricardo Vanni
 */
public class ConexaoTest extends ConexaoDAO {

    Connection conn = null;

    public ConexaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        conn = conectarHsqldb();
    }

    @After
    public void tearDown() {
    }

//    @Test
    public void testConexaoDriver() throws Exception {
        try {
            Assert.assertNotNull(conn);

//            StringBuilder sql = new StringBuilder();
//
//            sql = new StringBuilder();
//            sql.append("\n SELECT * from lancamento");
//
//            rs = stmt.executeQuery(sql.toString());
//
//            while (rs.next()){
//                System.out.println(rs.getString("nome"));
//            }
//
//            sql = new StringBuilder();
//            sql.append("\n INSERT INTO lancamento(nome, data, valor, idtipolancamento) ");
//            sql.append("\n VALUES(?,?,?,?) ");
//
//            ps = conn.prepareStatement(sql.toString());
//            ps.setString(1, "Joao");
//            ps.setString(2, "10/10/2017");
//            ps.setDouble(3, 12.65);
//            ps.setInt(4, 1);
//            ps.execute();
//
//            sql = new StringBuilder();
//            sql.append("\n SELECT * from lancamento");
//
//            rs = stmt.executeQuery(sql.toString());
//
//            while (rs.next()){
//                System.out.println(rs.getString("nome"));
//            }
//
//            fechaConexao(conn, stmt, rs);
        } catch (Exception e) {
            throw e;
        }
    }
}
