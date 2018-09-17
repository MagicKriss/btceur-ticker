# CoinbasePro websocket API test
A simple application that connects to the CoinbasePro WebSocket API, subscribes to Ticker channel for BTC to EUR currency course and stores that to MongoDB every X seconds. If no update on price has been made, the latest value is stored to the database.
MongoDB is used as a database for its object-based no-SQL properties. Database specialized specificaly for time series storage, like InfluxDB, could have been an even better choice.
