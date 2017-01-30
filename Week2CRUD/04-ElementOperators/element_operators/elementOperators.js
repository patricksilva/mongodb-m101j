db.moviesDetails.find({ "tomato.meter": { $exists: true } })

db.moviesDetails.find({ "tomato.meter": { $exists: false } })

// Value of $type may be either a BSON type number or the string alias
// See https://docs.mongodb.org/manual/reference/operator/query/type
db.moviesScratch.find({ _id: { $type: "string" } })
db.moviesScratch.find({ _id: { $type: "number" } })
db.moviesScratch.find({ _id: { $type: "object" } })
db.moviesScratch.find({ _id: { $type: "array" } })
db.moviesScratch.find({ _id: { $type: true } })
db.moviesScratch.find({ _id: { $type: false } })
db.moviesScratch.find({ _id: { $type: null } })
