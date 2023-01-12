import 'package:flutter/material.dart';
import 'package:flutter_03_app_postnavidena/screens/contador_screen.dart';
//import 'package:flutter_03_app_postnavidena/screens/home_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      //home: HomeScreen(),
      home: ContadorScreen(),
    );
  }
}
