<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Static Web App</title>
    <link rel="stylesheet" href="/css/index.css">
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
                <a class="nav-link" href="about.html">About <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="details.html">Details</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="new-animal-form.html">Add New Animal</a>
            </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" style="display: flex" style="flex-flow: row nowrap">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

    <div class="hamster-container">
        <div class="campbell-hamster">
            <img class="hamster-image" src="./assets/Campbell Dwarf Hamster.jpg" alt="A Campbell Dward hamster">
            <h2> Campbell dwarf hamster</h2>
            <p> These breeds originate from Mangolia, northeastern China, and parts of central Asia. They are dward hamsters,
                randing from 2-4 inches. Dwarf hamsters are can live in small groups, but are usually solitary to due to 
                aggresion and territoriality. </p>
        </div>

        <div class="chinese-hamster">
            <img class="hamster-image" src="./assets/Chinese Hamster.jpg" alt="A Chinese hamster">
            <h2> Chinese hamster </h2>
            <p> These hamsters originate from the deserts and grasslands of northern China and Mangolia. 
                They range from 3 to 5 inches and are known for their slender builds. </p>
        </div>

        <div class="robo-hamster">
            <img class="hamster-image" src="./assets/Robo hamster.jpg" alt="A Roborovski dwarf hamster">
            <h2> Roborovski dwarf hamster </h2>
            <p> Originating from central Asia, Roborovski hamsters (or "Robo") were first discovered by Russian explorer Lieutenant Vsevolod Roborovski. 
                They range from 3 to 4 inches. Similar to Campbell dward hamsters, they can be kept in groups but are typically better of solitary.  </p>
        </div>

        <div class="syrian-hamster">
            <img class="hamster-image" src="./assets/Syrian Hamster.avif" alt="A Syrian hamster">
            <h2> Syrian hamster </h2>
            <p> Originating from the Middle East, Syrians hamsters are the largest domesticated species of hamster at a size of 6 to 8 inches long;.</p>
        </div>

        <div class="winterwhite-hamster">
            <img class="hamster-image" src="./assets/Winter White Hamster.jpg" alt="A Winter White hamster">
            <h2> Winter white hamster </h2>
            <p> These hamsters originate form Asia, specifically grasslands in Siberia, Kazakhstan, Mongolia, and Manchuria. 
                They range from 3 to 4 inches and are known for their ability to change their coat color from grey-white to white in winter to camouflage. </p>
        </div>
    </div>

</body>
</html>