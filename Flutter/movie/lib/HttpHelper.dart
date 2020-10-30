import 'dart:convert';

import 'package:http/http.dart' as http;
import 'dart:io';

import 'package:movie/Movie.dart';

class HttpHelper {
  //final String uri = 'https://api.themoviedb.org/3/movie/550?api_key=89db676e08b3729fa899366e9ee46f2f';

  String urlDomain = 'https://api.themoviedb.org/3/movie/';
  String apiKey = 'api_key=89db676e08b3729fa899366e9ee46f2f';
  String urlLanguage = '&language=en-US';
  String urlPage = '&page=1';

  Future<List<Movie>> getPopularMovies() async {
    String typeOfQuery = 'popular?';
    String uri = urlDomain + typeOfQuery + apiKey + urlLanguage + urlPage;

    http.Response resp = await http.get(uri);

    if (resp.statusCode == 200) {
      final decodeJsonMap = json.decode(resp.body);
      Movies movieList = new Movies.fromjsonList(decodeJsonMap['results']);
      return movieList.movies;
    } else {
      return null;
    }
  }
}
