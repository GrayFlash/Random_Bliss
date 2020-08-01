const express = require('express');

const router = express.Router();

// Item Model
const Item = require('../../models/Items');

// @route GET  api/items
// @desc GET ALL Items
// @access Public
router.get('/', (req,res)=>{
    Item.find()
    .sort({ date: -1 })
    .then(items => res.json(items))
});

// @route POST  api/items
// @desc Make a POST request
// @access Public
router.post('/', (req,res)=>{
    const newItem = new Item({
        name: req.body.name
    });
});
// @route DELETE  api/items/id
// @desc Delete a item
// @access Public
router.delete('/id', (req,res)=>{
    console.log(req.params.id)
   Item.findById(req.params.id)
   .then(item => item.remove()
   .then(() => res.json({success: true})))
   .catch(err => res.status(404).json({ success: false}))
});

module.exports = router;