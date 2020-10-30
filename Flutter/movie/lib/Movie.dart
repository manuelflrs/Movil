class Movies {
  List<Movie> movies = new List();
  Movies.fromjsonList(List<dynamic> json) {
    if (json == null) return;

    for (var item in json) {
      Movie movie = new Movie.fromJsonMap(item);
      movies.add(movie);
    }
  }
}

class Movie {
  double popularity;
  int voteCount;
  bool video;
  String posterPath;
  int id;
  bool adult;
  String title;
  double vote_average;

  Movie(this.popularity, this.voteCount, this.video, this.posterPath, this.id,
      this.adult, this.title, this.vote_average);

  Movie.fromJsonMap(Map<String, dynamic> json) {
    this.popularity = json['popularity'] / 1;
    this.voteCount = json['voteCount'];
    this.video = json['video'];
    this.posterPath = json['posterPath'];
    this.id = json['id'];
    this.adult = json['adult'];
    this.title = json['title'];
    this.vote_average = json['vote_average'] / 1;
  }
}
