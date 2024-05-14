from flask import Flask, jsonify, request
from chat import get_response
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

@app.route('/chatbot', methods=['POST'])
def add_income():
  question = request.get_json().get("question")
  print("Question: ",question)

  answer = get_response(question)
  print("Answer: ",answer)

  response = {"answer":answer}

  return jsonify(response)

if(__name__ == "__main__"):
  app.run(debug=True)
