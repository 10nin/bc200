(ns bc200.core)

(defrecord Block [index, previousHash, timestamp, data, hash])
(def sockets [])
;; Message-Type
;; - QUERY_LATEST
;; - QUERY_ALL
;; - RESPONSE_BLOCKCHAIN
(defn getTimeStamp []
  nil)
(defn getGenesisBlock []
  (->Block (0, "0", (getTimeStamp), "my genesis block!!", "816534932c2b7154836da6afc367695e6337db8a921823784c14378abed4f7d7")))
(def blockchain (list getGenesisBlock))
(defn initHttpServer []
  ;;TODO: implement server initialize
  )
(defn initP2PServer []
  ;;Web socket ...??
  )
;; initConnection [ws]
;; initMessageHandler [ws]
;; initErrorHandler [ws]
(defn getLatestBlock
  (last blockchain))
(defn generateNextBlock [blockData]
  (let [previousBlock (getLatestBlock),
        nextIndex (+ (:index previousBlock) 1),
        nextTimeStamp (getTimeStamp),
        nextHash (calculateHash nextIndex (:hash previousBlock) nextTimeStamp blockData)]
  (->Block nextIndex (:hash previousBlock) nextTimeStamp blockData nextHash)))x
