<%-- 
    Document   : index
    Created on : 11/08/2020, 15:53:07
    Author     : paiz2
--%>

<%@page import="modelo.Productos" %>
<%@page import="modelo.Marca" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        
    </head>
    <body>
        <h1>PRODUCTOS</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_productos" onclick="limpiar()">Nuevo</button>
        
    <div class="container">
          <div class="modal fade" id="modal_productos" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_productos" method="post" class="form-group">
               <label for="lbl_id_productos" ><b>ID PRODUCTOS</b></label>
                <input type="text" name="txt_id_productos" id="txt_id" class="form-control" value="0"  readonly> 
                <label for="lbl_producto" ><b>PRODUCTO</b></label>
                <input type="text" name="txt_producto" id="txt_producto" class="form-control" placeholder="Ejemplo: 0001" required>
                <label for="lbl_descripcion" ><b>DESCRIPCION</b></label>
                <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control" placeholder="Ejemplo: descripcion1" required>
                <label for="lbl_precio_costo" ><b>PRECIO COSTO</b></label>
                <input type="number" name="txt_precio_costo" id="txt_precio_costo" class="form-control" placeholder="Ejemplo: Q0000" required>
                <label for="lbl_precio_venta" ><b>PRECIO VENTA</b></label>
                <input type="number"  name="txt_precio_venta" id="txt_precio_venta" class="form-control" placeholder="Ejemplo: Q000" required>
                <label for="lbl_existencia" ><b>EXISTENCIA</b></label>
                <input type="number" name="txt_existencia" id="txt_telefono" class="form-control" placeholder="Ejemplo: 001" required>
                <label for="lbl_marca" ><b>MARCA</b></label>
                <select name="drop_productos" id="drop_productos" class="form-control">
                    <% 
                        Marca marca = new Marca();
                        HashMap<String,String> drop = marca.drop_productos();
                         for (String i:drop.keySet()){
                             out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                         }
                         
                    
                    %>
                </select>
                <br>
                <button name="btn_agregar" id="btn_agregar"  value="agregar" class="btn btn-primary btn-lg">Agregar</button>
                <button name="btn_modificar" id="btn_modificar"  value="modificar" class="btn btn-success btn-lg">Modificar</button>
                <button name="btn_eliminar" id="btn_modificar"  value="eliminar" class="btn btn-danger btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false" >Eliminar</button>
                <button type="button" class="btn btn-warning btn-lg" data-dismiss="modal">Cerrar</button>
            </form>
        </div>
      </div>
      
    </div>
  </div>
        
        
           
    <table class="table table-striped">
    <thead>
      <tr>
        <th>Producto</th>
        <th>Descripcion</th>
        <th>Pre. Costo</th>
        <th>Pre. Venta</th>
        <th>Existencia Bodega</th>
        <th>Nombre Marca</th>
      </tr>
    </thead>
    <tbody id="tbl_productosss">
        <% 
        Productos productos = new Productos();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = productos.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id_productos=" + tabla.getValueAt(t,0) + " data-id_marca=" + tabla.getValueAt(t,8) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
            out.println("</tr>");
        
        }
        %>
      
    </tbody>
  </table>
  </div>
      

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script type="text/javascript">
    function limpiar(){
        $("#txt_id_productos").val(0);
       $("#txt_producto").val('');
       $("#txt_descripcion").val('');
       $("#txt_precio_costo").val('');
       $("#txt_Precio_venta").val('');
       $("#txt_existencia").val('');
       $("#txt_marca").val('');
       $("#drop_productos").val(1);
    }
    
    $('#tbl_productos').on('click','tr td',function(evt){
       var target,id_productos,producto,descripcion,precio_costo,precio_venta,existencia,id_marca; 
       target = $(event.target);
       id_productos = target.parent().data('id_productos');
       producto = target.parent("tr").find("td").eq(0).html();
       descripcion = target.parent("tr").find("td").eq(1).html();
       precio_costo= target.parent("tr").find("td").eq(2).html();
       precio_venta = target.parent("tr").find("td").eq(3).html();
       existencia = target.parent("tr").find("td").eq(4).html();
       $("#txt_id_productos").val(id_productos);
       $("#txt_producto").val(producto);
       $("#txt_descripcion").val(descripcion);
       $("#txt_precio_costo").val(precio_costo);
       $("#txt_precio_venta").val(precio_venta);
       $("#txt_existencia").val(existencia);
       $("#drop_productos").val(id_marca);
       $("#modal_productos").modal('show');
    });
    
</script>
    </body>
</html>
