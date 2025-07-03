개요 : Redis에 최근 검색어를 저장하고 불러오는 Springboot 기반의 기본코드입니다. 

목적 : Redis 의 기본문법을 알아보기 위한 내용입니다. 

사용강의 : 이커머스 프로젝트로 배우는 NoSQL & 대용량 데이터 처리 - 캐싱과 검색최적화-캐싱

---

## Python API

`pyapi/app.py` 를 실행하면 Flask 기반의 간단한 모델 인퍼런스 API 서버가 실행됩니다. `MODEL_PATH` 환경변수로 모델 pkl 파일 경로를 지정할 수 있으며 기본값은 `model.pkl` 입니다.

### 실행 방법

```bash
cd pyapi
pip install -r requirements.txt
python app.py
```

POST `/predict` 엔드포인트에 다음과 같이 호출하여 예측값을 받을 수 있습니다.

```bash
curl -X POST -H "Content-Type: application/json" \
    -d '{"features": [1, 2, 3, 4]}' http://localhost:8000/predict
```
