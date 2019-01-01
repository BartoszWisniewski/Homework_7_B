<!doctype html>
<html lang="pl">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <title>Fibonacci</title>
</head>
<body style="background: #7abaff">
<div class="container-fluid" style="color: #6f42c1; background: rgba(144,154,162,0.95)">
<h1>Project by ${student}</h1>
<p>${grup}</p>
<p>Date: ${date}</p>
</div>
<main>
<div class="dropdown">
<h2>Hello, please insert number bigger than 0</h2>

<form name="myForm" action="" onsubmit="return checkInp()" method="post">
    Number: <input type="text" name="number">
    <input type="submit" value="Submit"></form>
</div>
</main>
<script>
    function checkInp()
    {
    var x=document.forms["myForm"]["number"].value;
    if (isNaN(x) || x < 0 )
    {
    alert("Must input correct value");
    return false;
    }
    }
</script>
    <!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
</body>
</html>
