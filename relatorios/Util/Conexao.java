/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Silva
 */
public class Conexao
{
    
    private static Connection conexao;
    
    private Conexao(){}
    
    public static Connection getConexao()
    {
    if(conexao == null)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/uber", "root", "");
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        return conexao;
    }
}