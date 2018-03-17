<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="icon" type="image/jpg" href="https://png.icons8.com/color/1600/google-maps.png">
  <title> Mark on GG Maps</title>
</head>
<body>
      <div class="container">
              <form method="post" action="map.php">
                    <label for="latitude"><b>Marked Latitude</b></label>
                    <input type="text" name="latitude" required>
                    </br>
                    <label for="longitude"><b>Marked Longitude</b></label>
                    <input type="text" name="longitude" required>
                    
                    <p style="color:blue; font-size: 12px;"><i>(Nhập thêm để tính khoảng cách)</i></p>
                    
                    <label for="slat"><b>Destination Latitude</b></label>
                    <input type="text" value="" name="slat">
                    </br>
                    <label for="slng"><b>Destination Longitude</b></label>
                    <input type="text" value="" name="slng">
                    </br>
                    <button type="submit">Marker/Get distance</button>
                    </form>
      </div>
</body>
</html>