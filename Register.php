<?php
    $con = mysqli_connect("localhost", "id8247084_usernone	", "qwertyui", "id8247084_user");

    $name = $_POST["nama"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $statement = mysqli_prepare($con, "INSERT INTO user (nama, username, password) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "siss", $nama, $username, $password);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>