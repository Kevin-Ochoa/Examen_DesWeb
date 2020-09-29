package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Productos;
import modelo.Marca;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Productos</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>PRODUCTOS</h1>\n");
      out.write("        <button type=\"button\" class=\"btn btn-info btn-lg\" data-toggle=\"modal\" data-target=\"#modal_productos\" onclick=\"limpiar()\">Nuevo</button>\n");
      out.write("        \n");
      out.write("    <div class=\"container\">\n");
      out.write("          <div class=\"modal fade\" id=\"modal_productos\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("    \n");
      out.write("      <!-- Modal content-->\n");
      out.write("      <div class=\"modal-content\">\n");
      out.write("        <div class=\"modal-body\">\n");
      out.write("            <form action=\"sr_productos\" method=\"post\" class=\"form-group\">\n");
      out.write("               <label for=\"lbl_id_productos\" ><b>ID PRODUCTOS</b></label>\n");
      out.write("                <input type=\"text\" name=\"txt_id_productos\" id=\"txt_id\" class=\"form-control\" value=\"0\"  readonly> \n");
      out.write("                <label for=\"lbl_producto\" ><b>PRODUCTO</b></label>\n");
      out.write("                <input type=\"text\" name=\"txt_producto\" id=\"txt_producto\" class=\"form-control\" placeholder=\"Ejemplo: 0001\" required>\n");
      out.write("                <label for=\"lbl_descripcion\" ><b>DESCRIPCION</b></label>\n");
      out.write("                <input type=\"text\" name=\"txt_descripcion\" id=\"txt_descripcion\" class=\"form-control\" placeholder=\"Ejemplo: descripcion1\" required>\n");
      out.write("                <label for=\"lbl_precio_costo\" ><b>PRECIO COSTO</b></label>\n");
      out.write("                <input type=\"number\" name=\"txt_precio_costo\" id=\"txt_precio_costo\" class=\"form-control\" placeholder=\"Ejemplo: Q0000\" required>\n");
      out.write("                <label for=\"lbl_precio_venta\" ><b>PRECIO VENTA</b></label>\n");
      out.write("                <input type=\"number\"  name=\"txt_precio_venta\" id=\"txt_precio_venta\" class=\"form-control\" placeholder=\"Ejemplo: Q000\" required>\n");
      out.write("                <label for=\"lbl_existencia\" ><b>EXISTENCIA</b></label>\n");
      out.write("                <input type=\"number\" name=\"txt_existencia\" id=\"txt_telefono\" class=\"form-control\" placeholder=\"Ejemplo: 001\" required>\n");
      out.write("                <label for=\"lbl_marca\" ><b>MARCA</b></label>\n");
      out.write("                <select name=\"drop_productos\" id=\"drop_productos\" class=\"form-control\">\n");
      out.write("                    ");
 
                        Marca marca = new Marca();
                        HashMap<String,String> drop = marca.drop_productos();
                         for (String i:drop.keySet()){
                             out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                         }
                         
                    
                    
      out.write("\n");
      out.write("                </select>\n");
      out.write("                <br>\n");
      out.write("                <button name=\"btn_agregar\" id=\"btn_agregar\"  value=\"agregar\" class=\"btn btn-primary btn-lg\">Agregar</button>\n");
      out.write("                <button name=\"btn_modificar\" id=\"btn_modificar\"  value=\"modificar\" class=\"btn btn-success btn-lg\">Modificar</button>\n");
      out.write("                <button name=\"btn_eliminar\" id=\"btn_modificar\"  value=\"eliminar\" class=\"btn btn-danger btn-lg\" onclick=\"javascript:if(!confirm('¿Desea Eliminar?'))return false\" >Eliminar</button>\n");
      out.write("                <button type=\"button\" class=\"btn btn-warning btn-lg\" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("           \n");
      out.write("    <table class=\"table table-striped\">\n");
      out.write("    <thead>\n");
      out.write("      <tr>\n");
      out.write("        <th>Producto</th>\n");
      out.write("        <th>Descripcion</th>\n");
      out.write("        <th>Precio costo</th>\n");
      out.write("        <th>Precio venta</th>\n");
      out.write("        <th>Existencia</th>\n");
      out.write("        <th>Marca</th>\n");
      out.write("      </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody id=\"tbl_productosss\">\n");
      out.write("        ");
 
        Productos productos = new Productos();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = productos.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_p=" + tabla.getValueAt(t,8) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
            out.println("</tr>");
        
        }
        
      out.write("\n");
      out.write("      \n");
      out.write("    </tbody>\n");
      out.write("  </table>\n");
      out.write("  </div>\n");
      out.write("      \n");
      out.write("\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function limpiar(){\n");
      out.write("        $(\"#txt_id_productos\").val(0);\n");
      out.write("       $(\"#txt_producto\").val('');\n");
      out.write("       $(\"#txt_descripcion\").val('');\n");
      out.write("       $(\"#txt_precio_costo\").val('');\n");
      out.write("       $(\"#txt_Precio_venta\").val('');\n");
      out.write("       $(\"#txt_existencia\").val('');\n");
      out.write("       $(\"#txt_marca\").val('');\n");
      out.write("       $(\"#drop_productos\").val(1);\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    $('#tbl_productos').on('click','tr td',function(evt){\n");
      out.write("       var target,id_productos,producto,descripcion,precio_costo,precio_venta,existencia; \n");
      out.write("       target = $(event.target);\n");
      out.write("       id_productos = target.parent().data('id_productos');\n");
      out.write("       producto = target.parent(\"tr\").find(\"td\").eq(0).html();\n");
      out.write("       descripcion = target.parent(\"tr\").find(\"td\").eq(1).html();\n");
      out.write("       precio_costo= target.parent(\"tr\").find(\"td\").eq(2).html();\n");
      out.write("       precio_venta = target.parent(\"tr\").find(\"td\").eq(3).html();\n");
      out.write("       existencia = target.parent(\"tr\").find(\"td\").eq(4).html();\n");
      out.write("       $(\"#txt_id_productos\").val(id_productos);\n");
      out.write("       $(\"#txt_producto\").val(producto);\n");
      out.write("       $(\"#txt_descripcion\").val(descripcion);\n");
      out.write("       $(\"#txt_precio_costo\").val(precio_costo);\n");
      out.write("       $(\"#txt_precio_venta\").val(precio_venta);\n");
      out.write("       $(\"#txt_existencia\").val(existencia);\n");
      out.write("       $(\"#drop_producto\").val(id_marca);\n");
      out.write("       $(\"#modal_productos\").modal('show');\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
