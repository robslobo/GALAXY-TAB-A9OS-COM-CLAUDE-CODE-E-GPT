# A9OS Launcher — conceito 0.1

Protótipo de launcher Android para Galaxy Tab A9+ 5G (SM-X216B), com interface tablet em português.

## O que já funciona
- Tela inicial em tema escuro.
- Relógio e data na abertura.
- Cartões de conceito A9OS e memória do dispositivo.
- Grade de aplicativos favoritos.
- Alternância para lista completa e busca local.
- Dock inferior.
- Atalhos tentam abrir os aplicativos instalados no dispositivo.
- Declarado como HOME launcher para poder ser escolhido como tela inicial.

## Limitações desta versão
- É um protótipo visual, não uma ROM nem um sistema operacional independente.
- O relógio/data são atualizados ao abrir o launcher; ainda não há atualização contínua.
- Os nomes de pacotes de alguns apps podem variar conforme a versão/região da Samsung.
- O cartão de 4 GB é informativo, não uma leitura em tempo real da RAM.
- A grade contém atalhos predefinidos; ainda não enumera automaticamente todos os aplicativos instalados.

## Como gerar o APK
1. Abra esta pasta no Android Studio (versão recente).
2. Aguarde a sincronização do Gradle.
3. Se solicitado, instale Android SDK Platform 35 e JDK 17.
4. Use Build > Build Bundle(s) / APK(s) > Build APK(s).
5. O APK estará em `app/build/outputs/apk/debug/app-debug.apk`.

Também é possível compilar pelo terminal, com Android SDK e Gradle disponíveis:
`gradle assembleDebug`

## Instalação
Transfira o APK para o tablet e instale. Depois vá em Configurações > Aplicativos > Aplicativos padrão > Aplicativo de início (o caminho pode variar) e selecione A9OS Launcher.
