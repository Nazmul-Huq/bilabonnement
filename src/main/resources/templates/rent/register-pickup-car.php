<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" th:href="@{/stylesheets/index.css}" href="..\static\stylesheets\index.css">
    <title>Registrering af PickUp biler</title>
</head>
<body>
<!-- menu inserted from fragments-->
<?php
<div class="menu-div" th:insert="/fragment/fragments.html::menu"></div>
<script src="conditionreport.js" defer></script>

<div class="body-div">
    <form style="text-align: center;
   "th:action="@{/rent/add-pickup-car}" method="post">

        <h1>Registrering af PickUp biler
        </h1>
        <div>
            <label>Lokation:
                <select name="location" onchange="showLocation(this.value)">
                    <option value="">Vælg DS forhandler</option>
                    <option value="1">Silkeborg</option>
                    <option value="2">Aalborg</option>
                    <option value="3">Holstebro</option>
                    <option value="4">Odense</option>
                    <option value="5">Virum</option>
                    <option value="6">Århus</option>
                </select>
            </label>
        </div>
        <br>
        <div>
            <label>Registreringsnr.:
                <input type="number" name="carRegNumber" placeholder="Registreringsnr.">
            </label>
        </div>
        <!--Todo automatic showing of type, condition report and id-->
        <br>
        <div>
            <label>Kørte km.:
                <input type="number" name="drivenPickupKm" placeholder="Km">
            </label>
        </div>
        <br>
        <div>
            <label>Tilstandsreport
                <!--<div th:each="conditionReport: ${conditionReportForReturned}"></div>-->
            </label>
        </div>
        <br>
        <div>
            <label>Dato:
                <input type="date" name="returnDate">
            </label>
        </div>
        <br>
        <div>
            <label>Medarbejdernr.:
                <input type="number" name="employeeId">
            </label>
        </div>
        <br>
        <button>Submit</button>
    </form>
</div>

<!-- footer content inserted from fragments-->
<div class="footer-div" th:insert="/fragment/fragments.html::footer"></div>
 ?>
</body>
</html>