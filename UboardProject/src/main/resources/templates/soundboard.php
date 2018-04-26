<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

    <style>
        .button{
            width: 50px;
            height: 50px;
            border-style: double;
            background-color: #ffffff;
        }
        body{
            background-color: #B7EDFF;
        }
        .clickable{
            background-color: mediumpurple;
        }
    </style>
    <head>
        <title>Uboard Soundboard</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
        <h1 align="center">Uboard Interactive Soundboard</h1>
        <div id ="table" align = "center"></div>
        <script>
            function hasSound(id)
            {
               if(true)
               {
                   return true;
               }
               else
               {
                   return false;
               }
               
            }
            
            function buildTable()
            {
                var id = 1;
                var string = "<table>";
                for(i = 0; i < 100; i++)
                {
                    string += "<tr>";
                    for(j = 0; j < 100; j++)
                    {
                               string += "<td>";
                               string += "<a href='/upload?id="+id+"'>";
                               string += "<div class=\"button\" align=\"center\" id ='"+id+"'>"+id+"</div></a>";
                        
                       
                            //string +="<audio id ='"+id+"' src='"+id+".mp3' preload ='auto'></audio>";
                            //string +="<button class = \"pressable\" style=\"background-color:lightblue\" id ='"+id+"' onclick=\"document.getElementById('"+id+"').play();>"+id+"</button>";
                    
                       
                       
                       string += "</td>";  
                       id++;
                    }
                    string += "</tr>";
                }
                string += "</table>";
                return string;
            }
            document.getElementById("table").innerHTML = buildTable();
        </script>
        
       <?php
            $servername = "localhost";
            $username = "root";
            $password = "root";
            $dbname = "soundstorage";
            $conn = new mysqli($servername, $username, $password, $dbname);
           if($conn->connect_error)
           {
                die("Connection failed: ".$conn->connect_error);
           }
           
           $sql = "SELECT id FROM sound";
           $result = $conn->query($sql);
           
           if($result->num_rows > 0)
           {
                $contents = array();
                while($row = $result->fetch_assoc())
                {
                    array_push($contents, $row[buttonnumber]);
                }
           }
          ?>
          <table>
          <?php
           $id = 1;
                for($i = 0; $i < 100; $i++)
                {
                    echo "<tr>";
                    for($j = 0; $j < 100; $j++)
                    {
                        if(in_array($id, $un))
                        {
                            $tempresult = $conn->query("select * from sound where buttonnumber = ".$id);
                            $line - $tempresult->fetch_assoc();
                            echo "<td>";
                            echo "<audio id ='".$id."' src='/sounds/".$line[filename]."' preload ='auto'></audio>";
                            echo "<button class = 'pressable' style= 'background-color: ".$line[color]."' id ='button".$id."' onclick='document.getElementById(\'".$id."\').play();>".$id."</button>";
                            echo "</td>";
                            
                        }
                        else
                        {
                          echo "<td>";
                          echo "<a href='/upload?id=".$id."'>";
                          echo "<div class='button' align='center' id ='button".$id."'>".$id."</div></a>";
                          echo "</td>";
                        }
                        $id++;
                    }
                    echo "</tr>";
                }
           
       ?>
          </table>
        
        
    

