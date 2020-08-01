"""Application entry point."""
from flask_login import create_app, LoginManager

app = create_app()

if __name__ == "__main__":
    app.run(host='0.0.0.0', debug=True)