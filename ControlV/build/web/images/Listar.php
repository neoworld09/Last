<?php ?>
<html>
    <head>
        <title>Listado de usuarios</title>
        <!-- Cabecera -->
        <?php include '../Plantillas/Cabecera.php'; ?>
    </head>    
    <boby>
        <!-- menu -->
        <?php include '../Plantillas/Menu.php'; ?> 

        <!-- contenido -->
        <div class="container">
            <br/>
            <h2>Lista de Pacientes  <a href="NuevoPaciente.php" class="btn btn-primary">Registrar Paciente</a> </h2> 
            <br/>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Identificación</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                    </tr>
                </thead>
                <tbody>
                <?php
                include '../../Conexion/Conexion.php';
                //CRUD
                //CREATE = INSERT INTO
                //READ = SELECT
                //UPDATE = UPDATE
                //DELTE = DELETE
                
                $sql = "SELECT * FROM pacientes";
                $consulta = $mysql->query($sql);
                if($consulta){
                  while($paciente = $consulta->fetch_object()){
                      echo "<tr> <td>$paciente->PacIdentificacion</td> <td>$paciente->PacNombres</td> <td>$paciente->PacApellidos</td> </tr>";
                  }  
                }else{
                    echo "Error en la consulta";
                }
                
                ?>    
                    
                </tbody>
            </table>
        </div>



        <!-- fotter -->        
<?php include '../Plantillas/PiePagina.php'; ?>

    </boby>
</html>

