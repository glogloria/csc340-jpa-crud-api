<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Animal Form</title>
    <link rel="stylesheet" href="/css/animal-form.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
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

    <h2 style="text-align: center"> Show us your hamster!</h2>
    <div class="add-animal-container">
        <form id="new-hamster" action="/hamsters" method="post" enctype="multipart/form-data">
            <input type="text" id="name" name="name" placeholder="Name" required>
            <input type="text" id="breed" name="breed" placeholder="Breed" required>
            <input type="number" id="age" name="age" placeholder="Age" required>
            <label for="picture">Upload a picture of your hamster!</label>
            <input type="file" id="picture" name="picture" accept="image/png, image/jpeg">    
            <div class="animal-description">
                <label for="animal-description">Description</label>
                <textarea id="description" name="description" placeholder="Description" style="height:200px"></textarea>
            </div>   
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/hamsters" class="btn btn-outline-danger">Cancel</a>
        </form>
    </div>


</body>
</html>