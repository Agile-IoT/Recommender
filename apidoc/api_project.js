define({
  "name": "Recommender",
  "version": "0.0.0",
  "description": "",
  "id": "df92793f-594d-71b1-c4e0-b60e6d71f6de",
  "timestamp": 1464527788688,
  "requests": [
    {
      "collectionId": "df92793f-594d-71b1-c4e0-b60e6d71f6de",
      "id": "7ffd2e2e-3e24-0fa7-ad7b-2fe995406adf",
      "name": "Get Profile",
      "description": "",
      "url": "http://54.213.147.198/:8080/recommender/getProfile",
      "method": "POST",
      "headers": "Content-Type: application/json\nAccept: application/json\n",
      "data": "{\n    \"devices\":null,\n  \t\"apps\":null,\n  \t\"wfs\":null ,\n    \"resources\":null\n}",
      "dataMode": "raw",
      "timestamp": 0,
      "version": 2,
      "time": 1467966767280
    },
    {
      "collectionId": "df92793f-594d-71b1-c4e0-b60e6d71f6de",
      "id": "a6b1f1e9-93bb-6076-3fc5-15042cc9ecc9",
      "name": "Get Application Recommendation",
      "description": "",
      "url": "http://localhost:8080/agileRecommender/getCBAppRecomm",
      "method": "POST",
      "headers": "Content-Type: application/json\nAccept: application/json\n",
      "data": "{\n  \"title\":\"fitness\",\n  \"href\":null\n}",
      "dataMode": "raw",
      "timestamp": 0,
      "version": 2,
      "time": 1468231578339
    },
    {
      "collectionId": "df92793f-594d-71b1-c4e0-b60e6d71f6de",
      "id": "f678017c-ba18-8e9e-1b64-b0678d565156",
      "name": "Get WF Recommendation",
      "description": "",
      "url": "http://localhost:8080/agileRecommender/getWFRecomm",
      "method": "POST",
      "headers": "Content-Type: application/json\nAccept: application/json\n",
      "data": "{\n    \"type\":null,\n  \t\"datatag\":\"ibm\",\n  \t\"dataowner\":null ,\n    \"href\":null\n}",
      "dataMode": "raw",
      "timestamp": 0,
      "version": 2,
      "time": 1467792520524
    }
  ],
  "sampleUrl": false,
  "apidoc": "0.2.0",
  "generator": {
    "name": "apidoc",
    "time": "2016-07-11T12:02:57.581Z",
    "url": "http://apidocjs.com",
    "version": "0.16.1"
  }
});