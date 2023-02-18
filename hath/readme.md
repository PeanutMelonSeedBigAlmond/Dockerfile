# An image for Hentai@Home

## Usage

`docker run -it -v /your/cache/dir:/cache -v /your/download/dir:/download -e HATH_ID=<your client ID> -e HATH_KEY=<your client key> -p <port mapping> --name hath --restart unless-stopped peanutmelonseedbigalmond/hath`

## Note

1. The cache directory will be mounted automatically to protect it from lose your cache.

2. When you use your client to download archives, you shound mount your download directory.

3. The container **MUST** be run as root privilege (should not pass `-u` or `--user` argumant) or it may cause some issues.