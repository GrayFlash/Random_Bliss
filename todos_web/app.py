from flask import Flask, render_template, request, redirect

app = Flask(__name__)

todos = ["Groceries", "Homework"]

@app.route("/")
def mainPage():
    return render_template('todo.html', todos=todos)

@app.route("/add", methods=["GET", "POST"])
def add():
    if request.method == "GET":
        return render_template("add.html")
    else:
        todo = request.form.get("task")
        todos.append(todo)
        return redirect("/")
