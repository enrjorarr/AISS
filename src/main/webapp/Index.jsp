<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/css/vistaPrincipal.css">
	<link rel="stylesheet" type="text/js" href="/JavaScript/Scripts.js">
	<link href="https://apis.google.com/js/platform.js" rel="stylesheet">
	<link rel="shortcut icon" href="imagenes/icono.ico" />
	
	

<meta charset="UTF-8">
<title>Iceblock</title>
</head>
<body>

    <video class="videoBackground" id="video" muted autoplay loop>
        <source src="videos/videoPrueba.mp4">
    </video>

    <header>
            <h1 class="tituloInicio" id="titulo">Ice block</h1>
            <img class="logo" src="imagenes/Logo_transpa.png" alt="Logo Ice block"> 
    </header>

    <main class="main">
        <div class="textoBox">
            <p class="Pbox">What are you looking for?</p>
        </div>
        	<div class="search-box">
				<form action="EventKeywordTicketMasterController"  method="post">
				
				
					<input type="text" placeholder=" " id="keyword" name="key_word" /><span></span>
				
				</form>
            	    
        	</div>
 
        <div class="container" >
            	<a class="btn" type="submit" href="EventKeywordTicketMasterController">
                <svg width="277" height="62">
                    <defs>
                        <linearGradient id="grad1">
                            <stop stop-color="white"/>
                            <stop stop-color="white"/>
                        </linearGradient>
                    </defs>
                    <rect x="5" y="5" rx="25" fill="none" stroke="url(#grad1)" width="266" height="50"></rect>
                </svg>
               
              <span >surprise me</span>
              
         
            </a>
        </div>  
    </main>

</body>
</html>