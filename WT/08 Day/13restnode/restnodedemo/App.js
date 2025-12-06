const Express = require("express");
 const Mongoose = require("mongoose"); 
const BodyParser = require("body-parser"); 
var app = Express(); 
Mongoose.connect("mongodb://localhost:27017/empdb");
const schema = new Mongoose.Schema({ firstname: 'string', lastname: 'string' });
const PersonModel = Mongoose.model("customer", schema);

app.use(BodyParser.json()); 
app.use(BodyParser.urlencoded({ extended: true }));
app.get("/person", async (request, response) => {
    try {
        var result = await PersonModel.find().exec();
        response.send(result);
    } catch (error) {
        response.status(500).send(error);
    }
});
app.post("/person", async (request, response) => {
    try {        var person = new PersonModel(request.body);
        var result = await person.save();
        response.send(result);
    } catch (error) {
        response.status(500).send(error);
    }
});
app.get("/person/:id", async (request, response) => {
    try {
   
    var person = await PersonModel.findById(request.params.id).exec();
   
    response.send(person); 
   } 
   
   catch (error) {
    response.status(500).send(error); 
   } 
   
   });
   app.put("/person/:id", async (request, response) => { 
    try { 
    var person = await PersonModel.findById(request.params.id).exec();
	person.set(request.body); 
    var result = await person.save(); response.send(result); 
    } 
    catch (error) {
     response.status(500).send(error); } 
    });
    
    app.delete("/person/:id", async (request, response) => {
        try {
        var result = await PersonModel.deleteOne({ _id: request.params.id }).exec();
        response.send(result); 
       }
        catch (error) { response.status(500).send(error); }
        });
          app.listen(8081, () => { console.log("Listening at :3000..."); });
