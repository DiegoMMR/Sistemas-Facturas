/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Diego Mendez
 */
public class Conectar {
    
    //conexion a fremMysqlhost
    /*
    private static Connection conn;
    private static final String driver ="com.mysql.jdbc.Driver";
    private static final String user = "sql3143560";
    private static final String password = "CtUcRrxP4P";
    private static final String url = "jdbc:mysql://sql3.freemysqlhosting.net/sql3143560";
    */
    
    //conexiona mysql local
    
    private static Connection conn;
    private static final String driver ="com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "1234";
    private static final String url = "jdbc:mysql://localhost:3306/facturas";
    
    
    
    public PreparedStatement sqlCodigo;
    public Statement st;
    
    
    
    
    //conecta con la base de datos
    public Conectar(){
        
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado correctamente...");
        }catch(SQLException e) {
            System.out.println("Error al conectar Error: " + e.getMessage());
             JOptionPane.showMessageDialog(null, "Error al conectar");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //crea un nuevo usuario
    public void nuevoUsuario(Usuario _Usuario) throws SQLException
    {
        st = conn.createStatement();
        sqlCodigo = conn.prepareStatement("INSERT INTO Usuario (Usuario,Contraseña,Nombre,Correo,Tipo)" +
                                          "VALUES(?,?,?,?,?) ");
        sqlCodigo.setString(1, _Usuario.usuario);
        sqlCodigo.setString(2, _Usuario.pass);
        sqlCodigo.setString(3, _Usuario.nombre);
        sqlCodigo.setString(4, _Usuario.correo);
        sqlCodigo.setString(5, _Usuario.tipo);
        
        sqlCodigo.executeUpdate();
    }
    
    public void buscarUsuario(Usuario _Usuario, String usuario) throws SQLException
    {
        st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Usuario WHERE usuario = '" + usuario + "';");

        while (rs.next()) {

                _Usuario.usuario = rs.getString("Usuario");
                _Usuario.pass = rs.getString("Contraseña");
                _Usuario.tipo = rs.getString("Tipo");
                _Usuario.correo = rs.getString("Correo");
                _Usuario.nombre = rs.getString("Nombre");

            }
        
        
        if (rs.absolute(1)) {
            

        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            System.out.println("no entro");

        }
    }
    
    public void editarUsuario(Usuario _Usuario, String usuario) throws SQLException
    {
        st = conn.createStatement();
        sqlCodigo = conn.prepareStatement("UPDATE Usuario SET  Usuario=?, Nombre=?, Contraseña=?, Correo=?, Tipo=? WHERE Usuario='"+ usuario +"';");
        
        sqlCodigo.setString(1, _Usuario.usuario);
        sqlCodigo.setString(2, _Usuario.nombre);
        sqlCodigo.setString(3, _Usuario.pass);
        sqlCodigo.setString(4, _Usuario.correo);
        sqlCodigo.setString(5, _Usuario.tipo);
        
        
        sqlCodigo.executeUpdate();
    }
    
    public void borrarUsuario(String usuario) throws SQLException
    {
        st = conn.createStatement();
        sqlCodigo = conn.prepareStatement("DELETE FROM Usuario WHERE usuario='"+usuario+"';");     
        
        
        sqlCodigo.executeUpdate();
    }
    
    public void consultaUsuario(JTable jTable) throws SQLException
    {
        st = conn.createStatement();
        ResultSet rst = st.executeQuery("SELECT * FROM Usuario;"); 
        ResultSetMetaData rsMd = rst.getMetaData();        
        int noColumnas = rsMd.getColumnCount();
        
        //aca se prepara la tabla para poder modificarla 
        DefaultTableModel modelo = new DefaultTableModel(); 
        jTable.setModel(modelo);
        
        //esto añade los nombres de las columnas 
         for(int i=1; i<=noColumnas; i++)
         {
             modelo.addColumn(rsMd.getColumnLabel(i));
         }
         
         //se llena cada fila con los datos de la base
         while (rst.next()) {
             Object[] fila = new Object[noColumnas];

             for (int i = 0; i < noColumnas; i++) {
                 fila [i] = rst.getObject(i + 1);                  
             }
             
             modelo.addRow(fila);

         }
    }
    
    
    
    
    
    
    //crea un nuevo cliente
    public void nuevoCliente(Cliente _Cliente) throws SQLException
    {
        st = conn.createStatement();
        sqlCodigo = conn.prepareStatement("INSERT INTO Cliente (Nombre,Nit,Direccion,Telefono,Correo)" + 
                                          "VALUES(?,?,?,?,?) ");
        sqlCodigo.setString(1, _Cliente.nombre);
        sqlCodigo.setString(2, _Cliente.nit);
        sqlCodigo.setString(3, _Cliente.direccion);
        sqlCodigo.setString(4, _Cliente.telefono);
        sqlCodigo.setString(5, _Cliente.correo);
        
        sqlCodigo.executeUpdate();
    }
    
    //muestra todos los clientes dentro de la tabla
    public void consultaCliente(JTable jTable) throws SQLException
     {
        st = conn.createStatement();
        ResultSet rst = st.executeQuery("SELECT * FROM Cliente;"); 
        ResultSetMetaData rsMd = rst.getMetaData();        
        int noColumnas = rsMd.getColumnCount();
        
        //aca se prepara la tabla para poder modificarla 
        DefaultTableModel modelo = new DefaultTableModel(); 
        jTable.setModel(modelo);
        
        //esto añade los nombres de las columnas 
         for(int i=1; i<=noColumnas; i++)
         {
             modelo.addColumn(rsMd.getColumnLabel(i));
         }
         
         //se llena cada fila con los datos de la base
         while (rst.next()) {
             Object[] fila = new Object[noColumnas];

             for (int i = 0; i < noColumnas; i++) {
                 fila [i] = rst.getObject(i + 1);                  
             }
             
             modelo.addRow(fila);

         }
     }    
    
    //busca un cliente conforme al nit
    public void buscarCliente(String nit, Cliente _Cliente) throws SQLException
    {
        st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Cliente WHERE Nit = '" + nit + "';");

        while (rs.next()) {

                _Cliente.nombre = rs.getString("Nombre");
                _Cliente.nit = rs.getString("Nit");
                _Cliente.direccion = rs.getString("Direccion");
                _Cliente.telefono = rs.getString("Telefono");
                _Cliente.correo = rs.getString("Correo");

            }
        
        
        if (rs.absolute(1)) {
            

        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            System.out.println("no entro");

        }
    }
    
    //edita un cliente 
    public void editarCliente(Cliente _Cliente,String nit) throws SQLException
    {
        st = conn.createStatement();
        sqlCodigo = conn.prepareStatement("UPDATE Cliente SET  Nit=?, Nombre=?, Direccion=?, Telefono=?, Correo=? WHERE Nit='"+ nit +"';");
        
        sqlCodigo.setString(1, _Cliente.nit);
        sqlCodigo.setString(2, _Cliente.nombre);
        sqlCodigo.setString(3, _Cliente.direccion);
        sqlCodigo.setString(4, _Cliente.telefono);
        sqlCodigo.setString(5, _Cliente.correo);
        
        
        sqlCodigo.executeUpdate();
    }
    
    //elimina un cliente conforme al nit
    public void borrarCliente(String nit) throws SQLException
    {
         st = conn.createStatement();
        sqlCodigo = conn.prepareStatement("DELETE FROM Cliente WHERE Nit='"+nit+"';");     
        
        
        sqlCodigo.executeUpdate();
    }
    
    
    
    
    
    
    
    //crea una nueva factura
     public void ingresarFactura(Factura _Factura) throws SQLException
    {
        st = conn.createStatement();
        sqlCodigo = conn.prepareStatement("INSERT INTO Factura (NoFactura, Cliente, Nit, Fecha, Monto, Credito, Cancelada, Anulada)" +
                                          "VALUES(?,?,?,?,?,?,?,?) ");
        
        sqlCodigo.setString(1, _Factura.numero);
        sqlCodigo.setString(2, _Factura.cliente);
        sqlCodigo.setString(3, _Factura.nit);
        sqlCodigo.setDate(4, _Factura.fecha);
        sqlCodigo.setDouble(5, _Factura.monto);
        sqlCodigo.setInt(6, _Factura.credito);
        sqlCodigo.setBoolean(7, _Factura.cancelada);
        sqlCodigo.setBoolean(8, _Factura.anulada);
        
        sqlCodigo.executeUpdate();
    }     
     
     //muestra los datos de la tabla factura
     public void consultaFactura(JTable jTable) throws SQLException
     {
        st = conn.createStatement();
        ResultSet rst = st.executeQuery("SELECT * FROM Factura;"); 
        ResultSetMetaData rsMd = rst.getMetaData();        
        int noColumnas = rsMd.getColumnCount();
        
        //aca se prepara la tabla para poder modificarla 
        DefaultTableModel modelo = new DefaultTableModel(); 
        jTable.setModel(modelo);
        
        //esto añade los nombres de las columnas 
         for(int i=1; i<=noColumnas; i++)
         {
             modelo.addColumn(rsMd.getColumnLabel(i));
         }
         
         //se llena cada fila con los datos de la base
         while (rst.next()) {
             Object[] fila = new Object[noColumnas];

             for (int i = 0; i < noColumnas; i++) {
                 fila [i] = rst.getObject(i + 1);                  
             }
             
             modelo.addRow(fila);

         }
     }
     
     public void columnasFactura(JTable jTable) throws SQLException
     {
         st = conn.createStatement();
         
        ResultSet rst = st.executeQuery("SELECT * FROM Factura;"); 
        
        
        
        ResultSetMetaData rsMd = rst.getMetaData();        
        int noColumnas = rsMd.getColumnCount();
        
        //aca se prepara la tabla para poder modificarla 
        DefaultTableModel modelo = new DefaultTableModel(); 
        jTable.setModel(modelo);
        
        //esto añade los nombres de las columnas 
         for(int i=1; i<=noColumnas; i++)
         {
             modelo.addColumn(rsMd.getColumnLabel(i));
         }
     }
     
     //busca facturas dentro de un rango de fechas
     public void buscarFacturaFecha(JTable jTable,  java.sql.Date fecha1, java.sql.Date fecha2)throws SQLException
     {
         st = conn.createStatement();
         
        ResultSet rst = st.executeQuery("SELECT * FROM Factura WHERE Fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"';"); 
        
        
        
        ResultSetMetaData rsMd = rst.getMetaData();        
        int noColumnas = rsMd.getColumnCount();
        
        //aca se prepara la tabla para poder modificarla 
        DefaultTableModel modelo = new DefaultTableModel(); 
        jTable.setModel(modelo);
        
        //esto añade los nombres de las columnas 
         for(int i=1; i<=noColumnas; i++)
         {
             modelo.addColumn(rsMd.getColumnLabel(i));
         }
         
         //se llena cada fila con los datos de la base
         while (rst.next()) {
             Object[] fila = new Object[noColumnas];

             for (int i = 0; i < noColumnas; i++) {
                 fila [i] = rst.getObject(i + 1);                  
             }
             
             modelo.addRow(fila);

         }
         
         if (rst.absolute(1)) {
            

        } else {
            JOptionPane.showMessageDialog(null, "Facturas no encontradas");
            System.out.println("no entro");

        }
     }
     
     //busca facturas relacionadas con un cliente o nit
     public void buscarFacturaCliente(JTable jTable, String cliente, String nit) throws SQLException
     {
        st = conn.createStatement();
        ResultSet rst = st.executeQuery("SELECT * FROM Factura WHERE cliente='"+ cliente +"' OR nit ='"+ nit +"';"); 
        ResultSetMetaData rsMd = rst.getMetaData();        
        int noColumnas = rsMd.getColumnCount();
        
        //aca se prepara la tabla para poder modificarla 
        DefaultTableModel modelo = new DefaultTableModel(); 
        jTable.setModel(modelo);
        
        //esto añade los nombres de las columnas 
         for(int i=1; i<=noColumnas; i++)
         {
             modelo.addColumn(rsMd.getColumnLabel(i));
         }
         
         //se llena cada fila con los datos de la base
         while (rst.next()) {
             
             Object[] fila = new Object[noColumnas];

             for (int i = 0; i < noColumnas; i++) {
                 fila [i] = rst.getObject(i + 1);                  
             }
             
             modelo.addRow(fila);

         }
         
         if (rst.absolute(1)) {
            

        } else {
            JOptionPane.showMessageDialog(null, "Facturas no encontradas");
            System.out.println("no entro");

        }
         
     }
     
     //busca las facturas pendientes de pago
     public void bucarFacturaPendientePago(JTable jTable) throws SQLException
     {
         st = conn.createStatement();
        ResultSet rst = st.executeQuery("SELECT * FROM Factura WHERE Cancelada='0' AND Anulada='0' ;"); 
       
        

            

        ResultSetMetaData rsMd = rst.getMetaData();        
        int noColumnas = rsMd.getColumnCount();
        
        //aca se prepara la tabla para poder modificarla 
        DefaultTableModel modelo = new DefaultTableModel(); 
        jTable.setModel(modelo);
        
        //esto añade los nombres de las columnas 
         for(int i=1; i<=noColumnas; i++)
         {
             modelo.addColumn(rsMd.getColumnLabel(i));
         } 
          
         
         //se llena cada fila con los datos de la base
         while (rst.next()) {
             
             
             Object[] fila = new Object[noColumnas];

             for (int i = 0; i < noColumnas; i++) {
                 fila [i] = rst.getObject(i + 1);
                                
                 
             }
             
             modelo.addRow(fila);  
             
         }
         
         if (rst.absolute(1)) {
            

        } else {
            JOptionPane.showMessageDialog(null, "Facturas no encontradas");
            System.out.println("no entro");

        }
        
        
     }
    
     //busca las facturas anuladas
     public void buscarFacturaAnulada(JTable jTable) throws SQLException
     {
         st = conn.createStatement();
        ResultSet rst = st.executeQuery("SELECT * FROM Factura WHERE Anulada='1' ;"); 
       
        

            ResultSetMetaData rsMd = rst.getMetaData();        
        int noColumnas = rsMd.getColumnCount();
        
        //aca se prepara la tabla para poder modificarla 
        DefaultTableModel modelo = new DefaultTableModel(); 
        jTable.setModel(modelo);
        
        //esto añade los nombres de las columnas 
         for(int i=1; i<=noColumnas; i++)
         {
             modelo.addColumn(rsMd.getColumnLabel(i));
         }
         
         //se llena cada fila con los datos de la base
         while (rst.next()) {
             Object[] fila = new Object[noColumnas];

             for (int i = 0; i < noColumnas; i++) {
                 fila [i] = rst.getObject(i + 1);                  
             }
             
             modelo.addRow(fila);

         }
         
         if (rst.absolute(1)) {
            

        } else {
            JOptionPane.showMessageDialog(null, "Facturas no encontradas");
            System.out.println("no entro");

        }
            
       
     }
     
     //edita una factura
    public void editarFactura(String numero, Factura _Factura) throws SQLException{
    
        st = conn.createStatement();
        sqlCodigo = conn.prepareStatement("UPDATE Factura SET NoFactura=?, Cliente=?, Nit=?, Fecha=?, Monto=?, Credito=?, Cancelada=?, Anulada=? WHERE NoFactura='"+numero+"';");
        
        sqlCodigo.setString(1, _Factura.numero);
        sqlCodigo.setString(2, _Factura.cliente);
        sqlCodigo.setString(3, _Factura.nit);
        sqlCodigo.setDate(4, _Factura.fecha);
        sqlCodigo.setDouble(5, _Factura.monto);
        sqlCodigo.setInt(6, _Factura.credito);
        sqlCodigo.setBoolean(7, _Factura.cancelada);
        sqlCodigo.setBoolean(8, _Factura.anulada);
        
        sqlCodigo.executeUpdate();
        
    }
    
    //elimina un registro por medio del numero de factura
    public void borrarFactura(String numero) throws SQLException{
        
        st = conn.createStatement();
        sqlCodigo = conn.prepareStatement("DELETE FROM Factura WHERE NoFactura='"+numero+"';");     
        
        
        sqlCodigo.executeUpdate();
    }     
    
    //busca facturas por medio del numero
    public void buscarFacturaNumero(String numero, Factura _Factura) throws SQLException {
        st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Factura WHERE NoFactura = '" + numero + "';");

        while (rs.next()) {

                _Factura.numero = rs.getString("NoFactura");
                _Factura.cliente = rs.getString("Cliente");
                _Factura.nit = rs.getString("Nit");
                _Factura.fecha = rs.getDate("Fecha");
                _Factura.credito = rs.getInt("Credito");
                _Factura.monto = rs.getDouble("Monto");
                _Factura.cancelada = rs.getBoolean("Cancelada");
                _Factura.anulada = rs.getBoolean("Anulada");

            }
        
        
        if (rs.absolute(1)) {
            

        } else {
            JOptionPane.showMessageDialog(null, "Factura no encontrada");
            System.out.println("no entro");

        }
        
    }
    
    //retorna la coneccion
    public Connection getConnection(){
        return conn;  
    }
    
    //desconecta la base de datos
    public void desconectar(){
    conn = null;
    }
    
    public void inicioSecion()
    {
        getConnection();
        
    }
    
    
    
    
    
}
