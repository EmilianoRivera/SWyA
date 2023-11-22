<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css.css">
        <style>  
body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    text-align: center;
    margin: 20px;
}

h1 {
    color: #333;
}

form {
    background-color: #fff;
    border: 1px solid #ddd;
    padding: 20px;
    margin: 20px auto;
    max-width: 400px;
    border-radius: 8px;
}

label {
    display: block;
    margin-bottom: 8px;
}

input {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    box-sizing: border-box;
    border: 1px solid #ddd;
    border-radius: 4px;
}

button {
    background-color: #4caf50;
    color: white;
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #45a049;
}
    </style>
    </head>
    <body>
        <h1>RSA WEB </h1>
  <%
            if(request.getAttribute("e")!=null&&request.getAttribute("mel")==null) 
            {  
        %>          
         
          <!-- Formulario para cifrar mensaje -->
    <form id="formCifrar" action="Cifrar">
        <label for="mensajeCifrar"> a cifrar:</label>
        <input type="text" id="mensajeCifrar" name="mensajeCifrar" required>
        <button type="submit">Cifrar</button>
        <input type="hidden" value="<%=request.getAttribute("e")%>" name="e">
        <input type="hidden" value="<%=request.getAttribute("d")%>" name="d">
        <input type="hidden" value="<%=request.getAttribute("n")%>" name="n">
        
    </form>
        
        <%
            }
                %>
        
         <%
            if(request.getAttribute("mel")!=null) 
            {  
        %>          
    
        
        <form id="formDescifrar" action="Descifrar" >
       
        <button type="submit" >Descifrar</button>\
         <input type="hidden" value="<%=request.getAttribute("e")%>" name="e">
        <input type="hidden" value="<%=request.getAttribute("d")%>" name="d">
        <input type="hidden" value="<%=request.getAttribute("n")%>" name="n">
        <input type="hidden" value="<%=request.getAttribute("cifrado")%>" name="c">
        
    </form>
        
        <%
            }
                %>
        
      
    <%
            if(request.getAttribute("e")==null && request.getAttribute("mel")==null) 
            {  
        %>          
         
   
         <form id="formGenerarClaves" action="Claves" >
        <label for="tamanoPrimo">Tamaño del primo:</label>
        <input type="text" id="tamanoPrimo" name="tamanoPrimo" required>
        <button type="submit">Generar Claves</button>
        
    </form>
        
        
  
        
        <%
            }
                %>
                
                                                              <%
            if(request.getAttribute("des")!=null) 
            {  
        %>          
        <textarea id="cd" placeholder="<%=request.getAttribute("des")%>"  disabled></textarea>
   
        <%
            }
                %>
                
                
                <%
            if(request.getAttribute("cifradoc")!=null) 
            {  
        %>          
            <textarea id="cd" disabled><%=request.getAttribute("cifradoc")%></textarea>
   
        <%
            }
                %>
                
  
                                              <%
            if(request.getAttribute("mensaje")!=null) 
            {  
        %>          
                <script>
    window.onload=function() {
       alert( "<%=request.getAttribute("mensaje")%>");
    };
 </script>      
        <%
            }
                %>
    </body>
</html>

