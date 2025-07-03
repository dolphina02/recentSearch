from flask import Flask, request, jsonify
import joblib
import os

# Load the model when the app starts
MODEL_PATH = os.environ.get('MODEL_PATH', 'model.pkl')
if os.path.exists(MODEL_PATH):
    model = joblib.load(MODEL_PATH)
else:
    model = None

app = Flask(__name__)

@app.route('/predict', methods=['POST'])
def predict():
    if model is None:
        return jsonify({'error': 'Model not found'}), 500
    data = request.get_json(force=True)
    # Assume data is a list of features
    features = data.get('features')
    if features is None:
        return jsonify({'error': 'No features provided'}), 400
    try:
        prediction = model.predict([features])
        return jsonify({'prediction': prediction[0]}), 200
    except Exception as exc:
        return jsonify({'error': str(exc)}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8000)
