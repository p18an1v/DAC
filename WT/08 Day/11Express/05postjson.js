var express = require('express');
var app = express();
var bodyParser = require('body-parser');

// Create application/x-www-form-urlencoded parser

app.use(express.static('public'));
app.use(bodyParser.json());
app.get('/postdata',function (req, res) {
   res.sendFile( __dirname + "/" + "05post_form.html" );
})

app.post('/process_post', function (req, res) {
   // Prepare output in JSON format
   console.log(req);
   console.log(req.body);
   response = {
      first_name:req.body.first_name,
      last_name:req.body.last_name
   };
   console.log(response);
   res.end(JSON.stringify(response));
})

var server = app.listen(8081, function () {
   var host = server.address().address
   var port = server.address().port
   
   console.log("Example app listening at http://%s:%s", host, port)
})