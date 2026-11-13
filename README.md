# Grafik pracy – aplikacja na Androida (wersja bez własnych alarmów)

Aplikacja (Kotlin + WebView) nie ma własnego mechanizmu alarmów, powiadomień ani uruchamiania po restarcie.
Alarmy i przypomnienia o bramie ustawia w **systemowym zegarze telefonu**.
Jedyne uprawnienie: ustawianie alarmu w zegarze (SET_ALARM).

Interfejs i logika są w `app/src/main/assets/index.html`.
Budowanie APK: zakładka Actions → Build APK → Releases.
