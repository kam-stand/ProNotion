# Use official Node.js image
FROM node:18-alpine

# Set working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package.json package-lock.json* ./

# Install dependencies
RUN npm install

# Copy all source files
COPY . .

# Expose the default React dev server port
EXPOSE 5173

# Start the React app in development mode
CMD ["npm", "run", "dev", "--", "--host"]
