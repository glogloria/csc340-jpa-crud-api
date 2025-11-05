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
                <a class="nav-link" href="index.html">Home<span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about.html">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="details.html">Details</a>
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
        <form action="#">

            <label for="animal-name">Name</label>
            <input type="text" id="animal-name" name="animalName" placeholder="Enter their name">

            <label for="animal-breed">Breed</label>
            <input type="text" id="animal-breed" name="animalBreed" placeholder="Enter their breed">

            <label for="image-url">Image URL</label>
            <input type="text" id="image-url" name="imageURL" placeholder="Link an image of them">

            <label for="animal-description">Description</label>
            <textarea id="animal-description" name="animal-description" placeholder="Describe their personality" style="height:200px"></textarea>

            <input type="submit" value="Submit">

        </form>
    </div>


</body>
</html>