from flask import Flask, render_template

app = Flask(__name__)

todos = ["Groceries", "Homework"]

@app.route("/")
def mainPage():
    return render_template('todo.html', todos=todos)