import React from "react";
import { createRootRoute, Link, Outlet } from "@tanstack/react-router";
import { TanStackRouterDevtools } from "@tanstack/router-devtools";

export const Route = createRootRoute({
  component: () => (
    <>
      <div className="w-screen flex justify-center items-center gap-3 pt-16">
        <Outlet />
      </div>
    </>
  ),
});
