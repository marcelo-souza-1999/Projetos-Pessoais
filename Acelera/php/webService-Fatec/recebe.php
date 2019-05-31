<?php

	header('Content-Type: text/html; charset=utf-8');
	$port='COM3';
	$recebe = $_POST['codigo'];

	try
	{
		if($recebe != null)
		{
			$conecta=fopen($port,'w+');
			sleep(2);
			fwrite($conecta,$recebe);
			fclose($conecta);
		}
	}
	catch(PDOExcpetion $erro)
	{
		echo "Ocorreu um erro ao receber dados: = $erro";
	}
?>