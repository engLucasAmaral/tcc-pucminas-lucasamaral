FROM node:lts-alpine as build-stage
WORKDIR /app
COPY package*.json ./
#RUN npm i --package-lock-only
#RUN npm install -g npm@8.4.0

RUN npm install 
COPY . .

RUN npm run-script build
FROM nginx:1.18.0-alpine as  production-stage

COPY --from=build-stage /app/build /var/www/portal
COPY nginx.conf  /etc/nginx/conf.d/default.conf
ENV TZ=America/Sao_Paulo
CMD ["nginx", "-g", "daemon off;"]