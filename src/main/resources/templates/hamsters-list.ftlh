<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Hamster List</title>
</head>
<body>
    <!-- Bootstrap navigation bar-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/hamsters">Home<span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/hamsters/createForm">Add Hamster</a>
            </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" style="display: flex" style="flex-flow: row nowrap">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

    <div class="container" style="margin-top: 15px;">
        <h1>${title}</h1>
        <a href="/hamsters/createForm" class="btn btn-outline-primary" style="float:right;">Create New Hamster</a>

        <form action="/hamsters/name">
            <input type="text" name="key" placeholder="Search By Name &#128270;">
        </form>

        <!-- Hamster Table -->
        <table class="table table-striped rounded-3 overflow-hidden">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Breed</th>
            </tr>
            
            <#list hamstersList as hamster>
            <tr>
                <td>
                    <a href="/hamsters/${hamster.hamsterId?c}" style="color:#000000">${hamster.hamsterId?c}</a>
                </td>
                <td>${hamster.name}</td>
                <td>
                    <a href="/hamsters/breed/${hamster.breed}" style="color:#000000">${hamster.breed}</a>
                </td>
            </tr>
            </#list>
        </table>

    </div>

</body>
</html>