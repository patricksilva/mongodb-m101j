

> db.movieDetails.find( { runtime: { $gt: 90 } }).count()
> db.movieDetails.find( { runtime: { $gt: 90 } }, { title: 1, runtime: 1, _id: 0 }).count()





