<%-- 
    Document   : trainersList
    Created on : Feb 20, 2020, 9:37:43 AM
    Author     : dimit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <title>Trainers Management</title>

        <style>

            body{
                background-color:#f2f2f2;
            }
            .table{
                background-color:#fff;
                box-shadow:0px 2px 2px #aaa;
                margin-top:50px;
                text-align: center;
            }

            .error {
                color: #D8000C;
                background-color: #FFD2D2;
            }

        </style>


        <script type="text/javascript">
            function getTrainer(id) {
                $.ajax('/preUpdateTrainerSer?id=' + id,
                        {
                            dataType: 'json', // type of response data
                            timeout: 5000, // timeout milliseconds
                            success: function (data, status, xhr) {   // success callback function
                                $('#updTrId').val(data.trainerId);
                                $('#updTrName').val(data.trainerName);
                                $('#updTrSname').val(data.trainerSurname);
                                $('#updTrSubject').val(data.trainerSubject);
                            },
                            error: function (jqXhr, textStatus, errorMessage) { // error callback 
                                alert('Error: ' + errorMessage);
                            }
                        });
            }




        </script>
        <c:if test="${errors == 1}">
            <script>
                $(document).ready($(function () {
                    $("#mytoggler").trigger("click");
                })
                        );
            </script>

        </c:if>

    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="">List Of Trainers</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a id="mytoggler" href="" data-toggle="modal" data-target="#myModal">Add New Trainer</a></li>
                </ul>
            </div>
        </nav>


        <div class="container">
            <div class="row">
                <table class="table table-bordered">
                    <thead style="font-weight: bold;">
                    <td>#</td>
                    <td>Name</td>
                    <td>Surname</td>
                    <td>Subject</td>
                    <td colspan="2">Actions</td>
                    </thead>
                    <tbody>
                        <c:set var="i" value="0"/>
                        <c:forEach items="${trainerList}" var="tr">
                            <tr>
                                <c:set var="i" value="${i + 1}" scope="page"/>
                                <td>${i}</td>
                                <td>${tr.trainerName}</td>
                                <td>${tr.trainerSurname}</td>
                                <td>${tr.trainerSubject}</td>
                                <td>
                                    <a href="" class="glyphicon glyphicon-pencil" data-toggle="modal" data-target="#myupdModal" onclick="return getTrainer(${tr.trainerId});"></a>
                                </td>
                                <td><a href="delete/${tr.trainerId}" class="glyphicon glyphicon-trash"></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="container">
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">New Trainer Form</h4>
                        </div>
                        <div class="modal-body  justify-content-center">
                            <form:form method="POST" action="/insertTrainer"
                                       modelAttribute="Trainer">
                                <div class="form-group">
                                    <form:label path="trainerName">Name</form:label>
                                    <form:input class="form-control" type="text" path="trainerName" />
                                    <form:errors path="trainerName" class="error"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="trainerSurname">Surname</form:label>
                                    <form:input class="form-control" type="text" path="trainerSurname" />
                                    <form:errors path="trainerSurname" class="error"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="trainerSubject">Subject</form:label>
                                    <form:input class="form-control" type="text" path="trainerSubject" />
                                    <form:errors path="trainerSubject" class="error"/>
                                </div>
                                <div  class="row">
                                    <div  class="row">
                                        <div class="col-md-5"></div>
                                        <div class="col-md-2"><input class="btn btn-primary" type="submit" value="Submit" /></div>

                                        <div class="col-md-5"></div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>   
        </div>  


        <div class="container">
            <div class="modal fade" id="myupdModal" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Update Trainer Form</h4>
                        </div>
                        <div class="modal-body  justify-content-center">
                            <form action="/updateTrainer" method="post">

                                <div class="form-group" hidden>
                                    <label>Id</label>
                                    <input class="form-control" id="updTrId" type="text" name="id" class="input"/>
                                    <errors class="error"/>
                                </div>
                                <div class="form-group">
                                    <label>Name</label>
                                    <input class="form-control" id="updTrName" type="text" pattern="[A-Za-z]" min="5" max="40" name="name" class="input"/>
                                    <errors class="error"/>
                                </div>
                                <div class="form-group">
                                    <label>Surname</label>
                                    <input class="form-control" id="updTrSname" type="text" pattern="[A-Za-z]" min="5" max="40" name="surname" class="input"/>
                                    <errors class="error"/>
                                </div>
                                <div class="form-group">
                                    <label>Subject</label>
                                    <input class="form-control" id="updTrSubject" type="text" name="subject" class="input"/>
                                    <errors class="error"/>
                                </div>
                                <div  class="row">
                                    <div  class="row">
                                        <div class="col-md-5"></div>
                                        <div class="col-md-2"><input class="btn btn-primary" type="submit" value="Submit" /></div>
                                        <div class="col-md-5"></div>
                                    </div>
                                </div>

                        </div>
                    </div>
                </div>
            </div>   
        </div>  

    </body>

</html>
