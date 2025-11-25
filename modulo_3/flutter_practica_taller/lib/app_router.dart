import 'package:go_router/go_router.dart';

import 'pages/workshop_home_page.dart';
import 'pages/labor_page.dart';
import 'pages/parts_page.dart';
import 'pages/service_package_page.dart';
import 'pages/alignment_Balance_Page.dart';
import 'pages/quick_diagnosis_page.dart';

final GoRouter appRouter = GoRouter(
  routes: [
    GoRoute(
      path: '/',
      builder: (_, __) => const WorkshopHomePage(),
    ),
    GoRoute(
      path: '/labor',
      builder: (_, __) => const LaborPage(),
    ),
    GoRoute(
      path: '/parts',
      builder: (_, __) => const PartsPage(),
    ),
    GoRoute(
      path: '/service',
      builder: (_, __) => const ServicePackagePage(),
    ),
    GoRoute(
      path: '/balance',
      builder: (_, __) => const PantallaCotizacion(),
    ),
    GoRoute(
      path: '/diagnostico',
      builder: (_, __) => const PantallaDiagnostico(),
    ),
  ],
);
