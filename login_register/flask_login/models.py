from . import db
from flask_login import UserMixin
from werkzeug.security import generate_password_hash, check_password_hash


class User(UserMixin, db.Model):
    """User account model."""

    __tablename__ = 'flasklogin-users'

    id = db.Column(
        db.Integer,
        primary_key = True
    )

    name = db.column(
        db.String(100),
        nullable = False,
        unique = False
    )

    email = db.column(
        db.String(40),
        unique=True,
        nullable=False
    )

    password = db.column(
        db.String(200),
        primary_key = False,
        unique=False,
        nullable=False
    )

    website= db.column(
        db.String(60),
        index = False,
        unique = False,
        nullable = True
    )

    created_on = db.column(
        db.DateTime,
        index=False,
        unique=False,
        nullable=True
    )

    last_logn = db.Column(
        db.DateTime,
        index = False,
        unique=False,
        nullable=True
    )

    def set_password(self, password):
        self.password = generate_password_hash(password, method='sha256')

    def check_password(self, password):
        return check_password_hash(self.password, password)

    def __repr__(self):
        return '<User {}>'.format(self.username)