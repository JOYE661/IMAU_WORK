from waitress import serve

from project.wsgi import application

if __name__ == '__main__':
    serve(application, port='8210')