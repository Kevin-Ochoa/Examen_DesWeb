/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ABIX-XEL US
 */
public class Productos extends Articulo { 
    private int id_productos;
    
    private int id_marca;
    
    Conexion cn;
    public Productos() {}
    
    public Productos (int id_productos, int id_marca, int id, String producto, String descripcion, float precio_costo, float precio_venta, int existencia) {
        super(id, id_productos, id_marca, producto, descripcion, precio_costo, precio_venta, existencia);
        this.id_productos = id_productos;
        this.id_marca = id_marca;
    }

    public int getIdProductos() {
        return id_productos;
    }

    public void setIdProductos(int id_Productos) {
        this.id_productos = id_Productos;
    }

    public int getIdMarca() {
        return id_marca;
    }

    public void setIdMarca(int id_marca) {
        this.id_marca = id_marca;
    }
    public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "SELECT e.id_producto as id,e.producto,e.descripcion,e.precio_costo,e.precio_venta,e.existencia,p.id_marca,p.marca FROM productosss as e inner join marcasss as p on e.id_producto = p.id_marca;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id_productos","producto","descripcion","precio_costo","precio_venta","existencia","id_marca","marca"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[8];
      while (consulta.next()){
          datos[0] = consulta.getString("id_producto");
          datos[1] = consulta.getString("producto");
          datos[2] = consulta.getString("descripcion");
          datos[3] = consulta.getString("precio_costo");
          datos[4] = consulta.getString("precio_venta");
          datos[5] = consulta.getString("existencia");
          datos[6] = consulta.getString("id_marca");
          datos[7] = consulta.getString("marca");
          
          tabla.addRow(datos);
      
      }
      
     cn.cerrar_conexion();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }
    @Override
    public int agregar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "insert into productosss(id_producto, producto, descripcion, precio_costo, precio_venta, existencia, id_marca) values(?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1,getIdProductos());
            parametro.setString(2,getProducto());
            parametro.setString(3,getDescripcion());
            parametro.setFloat(4,getPrecio_costo());
            parametro.setFloat(5,getPrecio_venta());
            parametro.setInt(6,getExistencia());
            parametro.setInt(7,getId_marca());
         
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    @Override
    public int modificar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "update productosss set producto= ?,descriocion= ?,precio_costo= ?,precio_vemta= ?,existencia= ?,id_marca= ? where id_productos = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
           parametro.setInt(1,getIdProductos());
            parametro.setString(2,getProducto());
            parametro.setString(3,getDescripcion());
            parametro.setFloat(4,getPrecio_costo());
            parametro.setFloat(5,getPrecio_venta());
            parametro.setInt(6,getExistencia());
            parametro.setInt(7,getId_marca());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    @Override
    public int eliminar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "delete from productosss  where id_productos = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId_productos());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
}
