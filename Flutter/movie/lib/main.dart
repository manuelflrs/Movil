import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:movie/Home.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Movies App',
      home: Scaffold(
        appBar: AppBar(
          centerTitle: true,
          backgroundColor: Colors.yellow,
          title: Text(
            'Movies',
            style: GoogleFonts.pacifico(
              color: Colors.black,
              fontSize: 30.0,
            ),
          ),
        ),
        body: Home(),
      ),
    );
  }
}
