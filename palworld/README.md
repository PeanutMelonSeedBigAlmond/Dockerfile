# Palserver

幻兽帕鲁服务器

构建 Docker image: `docker build --no-cache -t palworld .`

### 说明

通过环境变量控制常用参数，仅在第一次生成存档有效

1. GAME_PORT 游戏端口，默认 8211

2. SERVER_NAME 服务器名，默认 Default Palworld Server

3. SERVER_DESC 服务器描述，默认为空

4. SERVER_PASSWORD 服务器密码，默认为空

5. ADMIN_PASSWORD 管理员密码，默认 changeme

6. IS_PUBLIC 是否公开服务器，默认 false

更多参数查看 Dockerfile

## 关于存档

存档位于容器内 `/opt/palworld/Pal/Saved` 文件夹