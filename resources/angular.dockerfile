# Stage 1: Build the Angular application
FROM node:18-alpine as build

# Set the working directory
WORKDIR /app

# Copy the package.json and package-lock.json (if available)
COPY package*.json ./

# Install the dependencies
RUN npm install

# Copy the entire project
COPY . .

# Build the Angular application
RUN npm run build

# Stage 2: Serve the application with Node.js
FROM node:lts

# Set the working directory
WORKDIR /app

# Copy the build output from the first stage
COPY --from=build /app/dist /app/dist

# Install Angular Universal dependencies
RUN npm install -g @nguniversal/express-engine

# Install production dependencies
COPY package*.json ./
RUN npm install --only=production

# Expose port 4000 (or any other port your server listens to)
EXPOSE 4000

# Start the Node.js server
CMD ["node", "dist/my-angular-project/server/server.mjs"]
