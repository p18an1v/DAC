const express = require("express");
const mongoose = require("mongoose");

const app = express();

//  Connect to MongoDB with recommended options
mongoose.connect("mongodb://127.0.0.1:27017/mydb")
.then(() => console.log(" Connected to MongoDB"))
.catch(err => console.error(" MongoDB connection error:", err));

//  Define schema with validation
const personSchema = new mongoose.Schema({
  firstname: { type: String, required: true },
  lastname: { type: String, required: true }
});

//  Create model (collection will be `customers`)
const PersonModel = mongoose.model("customer", personSchema);

//  Middleware
app.use(express.json());

// ------------------- ROUTES -------------------

// GET all persons
app.get("/person", async (req, res, next) => {
  try {
    const result = await PersonModel.find().exec();
    res.json(result);
  } catch (error) {
    next(error);
  }
});

// POST new person
app.post("/person", async (req, res, next) => {
  try {
    const person = new PersonModel(req.body);
    const result = await person.save();
    res.status(201).json(result);
  } catch (error) {
    next(error);
  }
});

// GET person by ID
app.get("/person/:id", async (req, res, next) => {
  try {
    const person = await PersonModel.findById(req.params.id).exec();
    if (!person)
         return 
        res.status(404).send("Person not found");
    res.json(person);
  } catch (error) {
    next(error);
  }
});

// PUT update person by ID
app.put("/person/:id", async (req, res, next) => {
  try {
    const person = await PersonModel.findById(req.params.id).exec();
    if (!person)
         return
         res.status(404).send("Person not found");

    person.set(req.body);
    const result = await person.save();
    res.json(result);
  } catch (error) {
    next(error);
  }
});

// DELETE person by ID
app.delete("/person/:id", async (req, res, next) => {
  try {
    const result = await PersonModel.deleteOne({ _id: req.params.id }).exec();
    if (result.deletedCount === 0) {
      return res.status(404).send("Person not found");
    }
    res.send("Person deleted successfully");
  } catch (error) {
    next(error);
  }
});

// ------------------- ERROR HANDLER -------------------
app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).send("Something went wrong!");
});

// ------------------- SERVER -------------------
app.listen(8081, () => {
  console.log(" Server running at http://localhost:8081");
});
